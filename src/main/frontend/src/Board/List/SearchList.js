import {Link, useParams} from "react-router-dom";
import  "../../App.css";
import Side_Tab from "../../Tabs/Side_Tab";
import Search_Board from "../BoardComponent/Search_Board";
import User_Side_Tab from "../../Tabs/User_Side_Tab";
import React from "react";



// const user = JSON.parse(localStorage.getItem('user-info'))

function SearchList(){

    const {category, type, keyword} = useParams();

    return(
        <div className="container">
            <div className="cont_container">
                <div className="Side_Tab">
                    {localStorage.getItem('user-info') ?
                    <>
                       <User_Side_Tab />
                    </>
                    :
                    <>
                        <Side_Tab />
                    </>
                    }
                </div>
                    <div className="mid_container">
                        <div className="page_name">
                                <span>검색결과</span>
                        </div>
                      <div className="table_mid_container">
                            <Search_Board category={category} type={type} keyword={keyword} />

                    </div>



                </div>

            </div>


        </div>


    );
}
export default SearchList;