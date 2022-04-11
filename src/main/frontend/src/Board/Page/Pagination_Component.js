import React from 'react';
import '../../App.css';
import {Link, useParams} from "react-router-dom";

function Pagination_Component() {

    const {page} = useParams();
    const p = parseInt(page,10);


    return (
        <div className="pagination_container">
            <div className="pageNum">
            <Link to="#" className="link">Previous</Link>
             <span>23</span>
            <Link to="#" className="link">Next</Link>
            </div>
            <div className="page_Num_info">
                <span>23페이지 입니다</span>
            </div>
        </div>
    );
}

export default Pagination_Component;