import React from 'react';
import './Category.css';

function CategoryTab ({id,title,activeCate, setActiveCate}) {

    const click_Handle=()=>{
        setActiveCate(id);
    }

    return (
        <button  type="button" onClick={click_Handle} id="tab_button" className={activeCate === id? "active" : "" }>
            {title}
        </button>
    );
};

export default CategoryTab;