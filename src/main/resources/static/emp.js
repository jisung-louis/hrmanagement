// === 사원 관련 ===
const printEmps = async() => {
    // [1] 어디에
    const tbody = document.querySelector("#emp_list");
    const select = document.querySelector("#vacationList_empId-select");
    // [2] 무엇을
    let tbodyHtml = "";
    let selectHtml = `<option value="disabled">휴가 신청 사원을 선택하세요</option>`;

    const response = await axios.get("/emp");
    const data = response.data;
    for (let i = 0; i < data.length; i++) {
        const emp = data[i];
        tbodyHtml += `<tr>
                    <td><img src="https://placehold.co/100x100"/></td>
                    <td>${emp.ename}</td>
                    <td>${emp.dno}</td>
                    <td>${emp.clsf}</td>
                    <td><span class="update" onclick="updateEmp(${emp})">수정</span>
                        <span class="delete" onclick="deleteEmp(${emp})">삭제</span>
                    </td>
                </tr>`;

        // TODO : 17번 줄(emp.dno)이 숫자로 들어오는 걸 부서명(dname)으로 바꿔서 출력

        selectHtml += `<option value="${emp.eno}">${emp.ename}</option>`;
    }
    // [3] 출력
    tbody.innerHTML = tbodyHtml;
    select.innerHTML = selectHtml;
}
const addEmp = async() => {
    // [1] 입력값 받아오기
    const ename = document.querySelector("#emp_name-input").value;
    const clsf = document.querySelector("#emp_rank-input").value;
    const dno = document.querySelector("#emp_deptId-select").value;

    const emp = {ename, clsf, dno};

    const result = await axios.post("/emp", emp);
    if (result) {
        alert(`'${ename}'님이 등록되었습니다.`);
    }
    printEmps();
}
const updateEmp = async(beforeEmp) => {
    const eno = beforeEmp.eno;
    const ename = prompt("수정할 이름을 입력하세요 : ", beforeEmp.ename);
    const clsf = prompt("수정할 직급을 입력하세요 : ", beforeEmp.clsf);
    const dno = beforeEmp.dno;

    const emp = { eno, ename, clsf, dno };
    const result = await axios.put("/emp", emp);
    if (result) {
        alert("사원정보 업데이트에 성공했습니다.");
    }
    printEmps();
    printVacations();
}
const deleteEmp = async(emp) => {
    const result = await axios.delete(`/emp?eno=${emp.eno}`);
    if (result) {
        alert("사원정보 삭제에 성공했습니다.")
    }
    printEmps();
    printVacations();
}