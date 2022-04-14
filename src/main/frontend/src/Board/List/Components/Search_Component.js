import React from 'react';
import '../../../App.css';

function Search_Component(props) {
    return (
        <div className="search_con">
            <form action="/board/search?type=${type}&keyword=${keyword}" method="get" name="searchForm">
                <select name="type">
                    <option value="t">제목</option>  {/*보낼 값  = type: t */}
                    <option value="c">내용</option>
                    <option value="w">작성자</option>
                    <option value="tc">제목 + 내용</option>
                    <option value="tcw">제목 + 내용 + 작성자</option>
                </select>
                <input type="text" name="keyword"/> {/*보낼 값 key :입력값 */}
                <input className="search_button" type="submit" value="검색"/>
            </form>
        </div>
    );
}

export default Search_Component;