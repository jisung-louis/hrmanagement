// === 휴가 관련 ===
const printVacations = async() => {
    // [1] 어디에
    const list = document.querySelector("#vacation_list");
    // [2] 무엇을
    let html = "";
    const response = await axios.get("/vacation");
    const data = response.data;
    for (let i = 0; i < data.length; i++) {
        const vacation = data[i];
        html += `<div class="list">
                    <div class="top">
                        <span>${vacation.eno}</span>
                        <span onclick="cancelVacationRequest(${vacation.vno})">신청취소</span>
                    </div>
                    <div class="mid">
                        <span>${vacation.startDate} ~ ${vacation.endDate}</span>
                    </div>
                    <div class="bottom">
                        <span>사유: ${vacation.reason}</span>
                    </div>
                </div>`;
    }
    // TODO : 13번 줄(vacation.eno)이 숫자로 들어오는 걸 사원명(ename)으로 바꿔서 출력
    // [3] 출력
    list.innerHTML = html;
}
const addVacationRequest = async() => {
    // [1] 입력값 받아오기
    const eno = document.querySelector("#vacationList_empId-select").value;
    const startDate = document.querySelector("#vacationList_startDate-input").value;
    const endDate = document.querySelector("#vacationList_endDate-input").value;
    const reason = document.querySelector("#vacationList_reason-input").value;

    const vacation = {eno, startDate, endDate, reason};

    const result = await axios.post("/vacation", vacation);
    if (result) {
        alert("휴가가 신청되었습니다.");
    }
    printVacations();
}
const cancelVacationRequest = async(vno) => {
    const result = await axios.delete(`/vacation?vno=${vno}`);
    if (result) {
        alert("휴가신청 취소에 성공했습니다.")
    }
    printVacations();
}