// === 부서 관련 ===
const printDepts = async() => {
    // [1] 어디에
    const tbody = document.querySelector("#dept_list");
    const select = document.querySelector("#emp_deptId-select");
    // [2] 무엇을
    let tbodyHtml = "";
    let selectHtml = `<option value="disabled">부서를 선택하세요.</option>`;
    const response = await axios.get("/dept");
    const data = response.data;
    for (let i = 0; i < data.length; i++) {
        const dept = data[i];
        tbodyHtml += `<tr>
                    <td> ${dept.dname} </td>
                    <td>
                        <span class="update" onclick="">수정</span>
                        <span class="delete" onclick="">삭제</span>
                    </td>
                </tr>`;
        selectHtml += `<option value="${dept.dno}">${dept.dname}</option>`;
    }
    // [3] 출력
    tbody.innerHTML = tbodyHtml;
    select.innerHTML = selectHtml;

}
const addDept = async() => {

}
const updateDept = async() => {

}
const deleteDept = async() => {

}