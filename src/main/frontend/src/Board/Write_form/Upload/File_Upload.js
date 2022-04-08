// import {useState} from "react";
// import '../Write.css';
// import ImageUploading from 'react-images-uploading';
//
//
// function File_Upload(){
//
//
//     const [file, setFile] = useState([]);
//
//     const uploadSingleFile=(e)=> {
//         let ImagesArray = Object.entries(e.target.files).map((e) =>
//             URL.createObjectURL(e[1])
//         );
//         console.log(ImagesArray);
//         setFile([...file, ...ImagesArray]);
//         console.log("file", file);
//     }
//
//     /*    const upload=(e)=> {
//             e.preventDefault();
//             console.log(file);
//         }*/
//
//     const deleteFile=(e)=> {
//         const s = file.filter((item, index) => index !== e);
//         setFile(s);
//         console.log(s);
//     }
//
//     return(
//         <div className="file">
//             <span>이미지 업로드</span>
//
//             <div className="upload_image_wrapper">
//                 {file.length > 0 &&
//                     file.map((item, index) => {
//                         return (
//                             <div className="image_item_boxes"  key={item}>
//                                 <div className="image_item">
//                                     <img src={item} alt="" width="100px" height="100px"/>
//                                     <button type="button" className="upload_button" onClick={() => deleteFile(index)}>
//                                         삭제
//                                     </button>
//                                 </div>
//                                 <hr className="image_divider" />
//                             </div>
//                         );
//                     })}
//             </div>
//
//             <div className="form-group">
//                 <input
//                     type="file"
//                     className="form-control"
//                     onChange={uploadSingleFile}
//                     multiple
//                 />
//             </div>
//         </div>
//
//     );
// } export default File_Upload;