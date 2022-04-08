import React from 'react';

function Category_Contents({id, activeCate, children}) {
    return (

      activeCate === id ?  <div className="SideContents">
          {children}
        </div>
          :null
    );
};

export default Category_Contents;