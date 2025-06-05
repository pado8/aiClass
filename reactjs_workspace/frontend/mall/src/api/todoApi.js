import axios from "axios"

//백엔드 서버와 ajax 통신
//axios async await 사용. async 적용함수는 return 값이 promise 형태 await는 서버에서 응답이 오면 처리

//서버 주소
export const API_SERVER_HOST = 'http://localhost:8080'
const prefix = `${API_SERVER_HOST}/api/todo`

// 상세보기
export const getOne = async (tno) => {
    const res = await axios.get(`${prefix}/${tno}`);
    return res.data
}

// 목록
export const getList = async (pageParam) => {
    const { page, size } = pageParam
    const res = await axios.get(`${prefix}/list`, { params: { page: page, size: size } });
    return res.data
}

// 등록
export const postAdd = async (todoObj) => {
    const res = await axios.post(`${prefix}/`, todoObj);
    return res.data
}

// 삭제
export const deleteOne = async (tno) => {
    const res = await axios.delete(`${prefix}/${tno}`);
    return res.data
}

// 수정
export const putOne = async (todo) => {
    const res = await axios.put(`${prefix}/${todo.tno}`, todo);
    return res.data
}
