import React from "react";


function TabContents({id, activeTab, children}) {
    return(
        activeTab === id ? <div className="TabContents">
                {children}
            </div>
            :null
    );
};

export default TabContents;

