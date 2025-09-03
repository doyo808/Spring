const loginBtn = document.getElementById('loginBtn');
const inputID = document.getElementById('inputID');
const inputPW = document.getElementById('inputPW');

loginBtn.addEventListener('click', (e) => {
    const xhttp = new XMLHttpRequest();
    xhttp.open('POST', '/quiz/loginRequest');

    xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

    const idValue = encodeURIComponent(inputID.value);
    const pwValue = encodeURIComponent(inputPW.value);

    xhttp.onload = function() {
        if (xhttp.status === 200) {
            const response = xhttp.responseText.trim(); 
            if (response === 'success') {
                window.location.href = `/success?ID=${idValue}`; 
            } else {
                alert('로그인 실패: 아이디 또는 비밀번호를 확인하세요.');
            }
        } else {
            alert('서버 에러 발생');
        }
    };

    xhttp.onerror = function() {
        alert('요청 실패');
    };

    xhttp.send(`ID=${idValue}&PW=${pwValue}`);

    inputID.value = '';
    inputPW.value = '';
});

