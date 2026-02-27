// === 부서 관련 ===
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
const addDept = async() => {

}
const updateDept = async() => {

}
const deleteDept = async() => {

}