import React from 'react';
import {useHistory} from 'react-router-dom';
import '../../../App.css';

function Search_Component({category}) {

    const history = useHistory();

    const _handleSearch = (e) => {
        e.preventDefault();

        const type = document.getElementById('type').value;
        const keyword = document.getElementsByName('keyword')[0].value;

        document.getElementsByName('keyword')[0].value = '';

        history.push(`/SearchList/${category}/${type}/${keyword}`);
    };

    return (
        <div className="search_con">
            <select id="type">
                <option value="t">제목</option>
                {/*보낼 값  = type: t */}
                <option value="c">내용</option>
                <option value="w">작성자</option>
                <option value="tc">제목 + 내용</option>
                <option value="tcw">제목 + 내용 + 작성자</option>
            </select>
            <input type="text" name="keyword"/> {/*보낼 값 key :입력값 */}
            <button className="search_button" onClick={(e) => _handleSearch(e)}>
                검색
            </button>
        </div>
    );
}

export default Search_Component;