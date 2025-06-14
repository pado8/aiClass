import { Outlet, useNavigate } from "react-router-dom";
import BasicLayout from "../../layouts/BasicLayout";
import { useCallback } from "react";
const IndexPage = () => {
    const navigate = useNavigate()
    const handleClickList = useCallback(() => {
        navigate({
            pathname: 'list'
        })
    })
    const handleClickAdd = useCallback(() => {
        navigate({
            pathname: 'add'
        })
    })
    return (
        <BasicLayout>
            <div className="w-full flex m-2 p-2 ">
                <div className="my-btn"
                    onClick={handleClickList}> LIST </div>
                <div className="my-btn"
                    onClick={handleClickAdd}> ADD </div>
            </div>
            <div className="flex flex-wrap w-full"> <Outlet /> </div>
        </BasicLayout >
    );
}
export default IndexPage;