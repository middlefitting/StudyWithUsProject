import {useState} from "react";
import '../Write.css';
import ImageUploading from 'react-images-uploading';


function File_Upload(){

   /* // 미리볼 사진 url 저장할 state
    const[fileImage, setImage] = useState("");

    //파일 저장
    const saveImage = (e)=>{
        setImage(URL.createObjectURL(e.target.files[0]));
    };
    {/!*           <input id="upload" ref="upload" type="file" accept="image/!*"
                               onInput={(event)=> {
                                   this.readFile(event)
                               }}
                               onClick={(event)=> {
                                   event.target.value = null
                               }}
                        />*!/}


    // 같은 파일 재업로드 설정
    const FileClicked=(e)=>{
        e.target.value = null;
    }

    //파일 삭제
    const deleteImage=(e)=>{
        URL.revokeObjectURL(fileImage);
        setImage("");
    };*/



    const [images, setImages] = useState([]);
    const maxNumber = 20;

    const onChange = (imageList, addUpdateIndex) =>{
        //data for submit
        console.log(imageList, addUpdateIndex);
        setImages(imageList);
    }

    return(
        <div className="file">
                <span>이미지 업로드</span>
            <div className="write_input_file">
                <ImageUploading
                    multiple
                    value={images}
                    onChange={onChange}
                    maxNumber={maxNumber}
                    dataURLKey="data_url">
                    {({
                          imageList,
                          onImageUpload,
                          onImageRemoveAll,
                          onImageUpdate,
                          onImageRemove,
                          isDragging,
                          dragProps,

                      }) => (
                        <div className="upload_image_wrapper">
                            <div className="upload_button_wrapper">
                                <button
                                    style={isDragging ? { color: 'red' } : undefined}
                                    onClick={onImageUpload}
                                    {...dragProps}
                                >
                                    사진 첨부하기
                                </button>
                                &nbsp;
                                <button onClick={onImageRemoveAll}>사진 모두 삭제</button>
                            </div>
                            {imageList.map((image, index) => (
                              <div className="image_item_boxes" key={index} >
                                <div className="image_item">
                                    <img src={image['data_url']} alt="" width="100" height="100" />
                                    <div className="image-item_btn-wrapper">
                                        <button className="upload_button" onClick={() => onImageUpdate(index)}>수정하기</button>
                                        <button className="upload_button" onClick={() => onImageRemove(index)}>삭제</button>
                                    </div>
                                </div>
                                  <hr className="image_divider" />
                              </div>
                            ))}

                        </div>


                    )}

                </ImageUploading>

            </div>
          </div>
    );
} export default File_Upload;