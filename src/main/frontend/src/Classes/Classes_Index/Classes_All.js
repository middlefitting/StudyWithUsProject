import React, {useState} from 'react';
import '../../App.css';
import '../Classes.css';
import CategoryTab from "../Side_Components/CategoryTab";
import Classes_Header_Front from "../Classes_Header/Classes_Header_Front";
import Classes_Header_All from "../Classes_Header/Classes_Header_All";
import Category_Contents from "../Side_Components/Category_Contents";
import Classes_Header_Back from "../Classes_Header/Classes_Header_Back";
import Classes_Header_Data from "../Classes_Header/Classes_Header_Data";
import Classes_Header_Mobile from "../Classes_Header/Classes_Header_Mobile";
import Classes_Content_Back from "../Classes_Content/Classes_Content_Back";
import Classes_Content_Front from "../Classes_Content/Classes_Content_Front";
import Classes_Content_Data from "../Classes_Content/Classes_Content_Data";
import Classes_Content_Mobile from "../Classes_Content/Classes_Content_Mobile";
import Classes_Content_All from "../Classes_Content/Classes_Content_All";

function Classes_All () {



    const [activeCate, setActiveCate] = useState("tab1");


    return (
        <div className="class_container">
            <div className="category">
                <div className="category_container">
                   <CategoryTab title='전체보기' id='tab1' activeCate={activeCate} setActiveCate={setActiveCate} />
                   <CategoryTab title='프로그래밍 언어' id='tab2' activeCate={activeCate} setActiveCate={setActiveCate} />
                   <CategoryTab title='웹 프론트엔드' id='tab3' activeCate={activeCate} setActiveCate={setActiveCate} />
                   <CategoryTab title='데이터베이스 설계' id='tab4' activeCate={activeCate} setActiveCate={setActiveCate} />
                   <CategoryTab title='모바일 개발' id='tab5' activeCate={activeCate} setActiveCate={setActiveCate} />
                </div>
            </div>


            <div className="class_content_wrap">
                <div className="detail_wrap" >
                    <Category_Contents id='tab1' activeCate={activeCate}>
                        <Classes_Header_All />
                    </Category_Contents>

                    <Category_Contents id='tab2' activeCate={activeCate}>
                        <Classes_Header_Back />
                    </Category_Contents>

                    <Category_Contents id='tab3' activeCate={activeCate}>
                        <Classes_Header_Front />
                    </Category_Contents>

                    <Category_Contents id='tab4' activeCate={activeCate}>
                        <Classes_Header_Data />
                    </Category_Contents>

                    <Category_Contents id='tab5' activeCate={activeCate}>
                        <Classes_Header_Mobile />
                    </Category_Contents>
                </div>

                <div className="class_wrap">
                    <Category_Contents id="tab1" activeCate={activeCate}>
                        <Classes_Content_All />
                    </Category_Contents>
                    <Category_Contents id="tab2" activeCate={activeCate}>
                        <Classes_Content_Back />
                    </Category_Contents>
                    <Category_Contents id="tab3" activeCate={activeCate}>
                        <Classes_Content_Front/>
                    </Category_Contents>
                    <Category_Contents id="tab4" activeCate={activeCate}>
                        <Classes_Content_Data />
                    </Category_Contents>
                    <Category_Contents id="tab5" activeCate={activeCate}>
                        <Classes_Content_Mobile />
                    </Category_Contents>
                </div>


            </div>
        </div>

    );
};

export default Classes_All;