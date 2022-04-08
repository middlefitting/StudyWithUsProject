import React from "react";


function Tab_Name({id, activeTab, children}) {
    return(
        activeTab === id ? <div className="Tab_Name">
                {children}
            </div>
            :null
    );
};

export default Tab_Name;

