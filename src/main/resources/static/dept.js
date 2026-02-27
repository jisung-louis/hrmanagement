// === 부서 관련 ===


//1. 모든부서조회
const printDepts = async() => {
    // [1] 어디에
    const tbody = document.querySelector("#dept_list");
    // [2] 무엇을
    let html = "";
    const response = await axios.get("/dept");
    const data = response.data;
    for (let i = 0; i < data.length; i++) {
        const dept = data[i];
        html += `<tr>
                    <td> ${dept.dname} </td>
                    <td>
                        <span class="update" onclick="">수정</span>
                        <span class="delete" onclick="">삭제</span>
                    </td>
                </tr>`;
    }
    // [3] 출력
    tbody.innerHTML = html;
}
printDepts(); //처음 html 을 띄울때 부서 전체 조회



//2.부서 추가하기
const addDept = async() => {

    //1.입력받은 dom객체를 가져온다.
    const dnameInput=document.querySelector("#dept_name-input"); //사용자가 입력한 값
    const dname=dnameInput.value;
    //2.입력받은 값으로 객체 생성
    const obj={dname};
    //3.배열 저장 axios를 이용한다.


    //수정할 거:사용자가 입력한 값이 null 값이면 성공이 안되게 하기
    const response=await axios.post("/dept",obj);
    const data=response.data;
    if(data==true){
        alert("부서 등록 성공!");
        dnameInput.value = "";
    }
    else{
        alert("부서 등록 실패");
    }
    printDepts();
} //func end
const updateDept = async() => {

}
const deleteDept = async() => {

}