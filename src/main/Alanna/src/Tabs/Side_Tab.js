import './Side_Tab.css'
function Side_Tab({id, title,activeTab, setActiveTab}){

    const handleClick=()=>{
        setActiveTab(id);
    }
    return(

                <li onClick={handleClick} className={activeTab === id? "active" : ""}>
                    {title}
                </li>

    );
}export  default Side_Tab;



/*
const TabNavItem=({id, title, activeTab, setActiveTab}) =>{

    const handleClick =()=>{
        setActiveTab(id);
    };

    return(
        <li onClick={handleClick} className={activeTab === id? "active" : ""}>
            {title}
        </li>
    );

};
export default TabNavItem;*/
