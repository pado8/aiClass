package org.zerock.guestbook.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.entity.Guestbook;
import org.zerock.guestbook.entity.QGuestbook;
import org.zerock.guestbook.repository.GuestbookRepository;

import java.util.Optional;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class GuestbookServiceImpl implements GuestbookService {

    private final GuestbookRepository repository;

    @Override
    public Long register(GuestbookDTO dto) {

        log.info("DTO------------------------");
        log.info(dto);
        Guestbook entity = dtoToEntity(dto);
        log.info(entity);
        repository.save(entity);
        return entity.getGno();
    }

//    @Override
//    public PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO) {
//        Pageable pageable = requestDTO.getPageable(Sort.by("gno").descending());
//        Page<Guestbook> result = repository.findAll(pageable);
//        Function<Guestbook, GuestbookDTO> fn = (entity -> entityToDto(entity));
//        return new PageResultDTO<>(result, fn );
//    }

    @Override
    public PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("gno").descending());
        BooleanBuilder booleanBuilder = getSearch(requestDTO); //검색 조건 처리
        Page<Guestbook> result = repository.findAll(booleanBuilder, pageable); //Querydsl 사용
        Function<Guestbook, GuestbookDTO> fn = (entity -> entityToDto(entity));
        return new PageResultDTO<>(result, fn );
    }


    @Override
    public GuestbookDTO read(Long gno) {
        Optional<Guestbook> result = repository.findById(gno);
        return result.isPresent()? entityToDto(result.get()): null;
    }

    @Override
    public void remove(Long gno) {
        repository.deleteById(gno);
    }

    @Override
    public void modify(GuestbookDTO dto) {

        //업데이트 하는 항목은 '제목', '내용'
        Optional<Guestbook> result = repository.findById(dto.getGno());
        if(result.isPresent()){
            Guestbook entity = result.get();
            entity.changeTitle(dto.getTitle());
            entity.changeContent(dto.getContent());
            repository.save(entity);
        }
    }

    // 검색조건생성. 동적쿼리
    private BooleanBuilder getSearch(PageRequestDTO requestDTO){
        String type = requestDTO.getType(); // 검색필드
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        QGuestbook qGuestbook = QGuestbook.guestbook;
        String keyword = requestDTO.getKeyword(); // 검색어
        BooleanExpression expression = qGuestbook.gno.gt(0L); // gno > 0 조건만 생성 인덱스 활용하게(좋은코딩)
        booleanBuilder.and(expression); // where gno > 0
        if(type == null || type.trim().length() == 0){ //검색 조건이 없는 경우 중지
            return booleanBuilder;
        }

        //검색 조건을 작성하기
        BooleanBuilder conditionBuilder = new BooleanBuilder();
        if(type.contains("t")){conditionBuilder.or(qGuestbook.title.contains(keyword));} // or title like '%spring%' 검색어가 spring인 경우
        if(type.contains("c")){conditionBuilder.or(qGuestbook.content.contains(keyword));} // or content like '%spring%'
        if(type.contains("w")){conditionBuilder.or(qGuestbook.writer.contains(keyword));} //  or writer like '%spring%'

        //모든 조건 통합
        booleanBuilder.and(conditionBuilder); // where gno > 0 and ( 검색조건 where절... )

        return booleanBuilder;
    }

}