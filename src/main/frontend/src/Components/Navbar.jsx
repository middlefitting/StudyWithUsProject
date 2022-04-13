import { useState, useRef, useEffect } from 'react';
import { Link, useHistory } from 'react-router-dom';
import $ from 'jquery';

import '../styles/css/Navbar.css'

// Contents Component
const Contents = () => {

  const history = useHistory();
  // const user_info = JSON.parse(localStorage.getItem('user-info'));
  const user = JSON.parse(localStorage.getItem('user-data'));
  const post = JSON.parse(localStorage.getItem('post-info'));

  // Function For Logout
  const _handleLogOut = () => {
    localStorage.clear();
    sessionStorage.clear();
    history.push("/");
    window.location.reload();
  };

  return (
      <>
        <Link to='/NoticeList' className='nav_content'>공지사항</Link>
        <Link to='/FreeList' className='nav_content'>게시판</Link>
        <Link to='/Study_List' className='nav_content'>스터디</Link>
        <Link to='/Classes_All' className='nav_content'>강좌</Link>
        {user ?
            <>
              <Link to='/MyPageList' className='nav_btn green'>{user.nickname}</Link>
              <div className='nav_btn red' onClick={() => _handleLogOut()}>LOGOUT</div>
            </>
            :
            <>
              <Link to='/signin' className='nav_btn green'>LOGIN</Link>
              <Link to='/signup' className='nav_btn red'>SIGNUP</Link>
            </>
        }
      </>
  );
};

// Main Component
const Component = () => {

  const mounted = useRef(false);
  const [width, setWidth] = useState(window.innerWidth);
  const [sideBar, setSideBar] = useState(false);

  // Function For Controlling Side Nav
  const _handleSideBar = () => {
    if (!sideBar) {
      $('.horizontal_line').addClass('toggle');
      $('.rotatory_line').addClass('toggle');
      $('.sidebar_container').css('transform', 'translateX(0)');
      setSideBar(!sideBar);
    } else {
      $('.horizontal_line').removeClass('toggle');
      $('.rotatory_line').removeClass('toggle');
      $('.sidebar_container').css('transform', 'translateX(100%)');
      setSideBar(!sideBar);
    }
  };

  // Bringing the width when the screen size changes
  // And once the width goes wider than 1200px sidebar's disabled
  $(window).on('resize', () => {
    if (mounted.current) {
      setWidth(window.innerWidth);
      if (width > 1199 && sideBar) {
        setSideBar(false);
      }
    }
  });

  // For avoiding an error of getting the screen width
  useEffect(() => {
    mounted.current = true;

    return () => {
      mounted.current = false;
    };
  }, []);

  return (
      <>
        <div className='nav_container'>
          <Link to='/' className='nav_title'>StudyWithUs</Link>
          {width > 1199 ?
              <div className={'nav_contents_wrapper'}><Contents /></div>
              :
              <>
                <div className='nav_toggle' onClick={() => _handleSideBar()}>
                  <div className='rotatory_line' />
                  <div className='horizontal_line' />
                  <div className='rotatory_line' />
                </div>
                <div className={'sidebar_container'}><Contents /></div>
              </>
          }
        </div>
        <div style={{ width: '100%', height: '80px' }} />
      </>
  );
};

export default Component;