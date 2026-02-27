// === 사원 관련 ===
const printEmps = async() => {
    // [1] 어디에
    const tbody = document.querySelector("#emp_list");
    // [2] 무엇을
    let html = "";
    const response = await axios.get("/emp");
    const data = response.data;
    for (let i = 0; i < data.length; i++) {
        const emp = data[i];
        html += `<tr>
                    <td><img src="https://placehold.co/100x100"/></td>
                    <td>${emp.ename}</td>
                    <td>${emp.dno}</td>
                    <td>${emp.clsf}</td>
                    <td><span class="update" onclick="updateEmp(emp.eno)">수정</span>
                        <span class="delete" onclick="deleteEmp(emp.eno)">삭제</span>
                    </td>
                </tr>`;
    }
    // [3] 출력
    tbody.innerHTML = html;
}
const addEmp = async() => {

}
const updateEmp = async(eno) => {

}
const deleteEmp = async(eno) => {

}