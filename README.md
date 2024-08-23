# 깃허브 잔디 꾸미기 설명서
### 어떤 서비스인가요?
- 개발자 여러분이 이용하는 Github는 git 작업에 따라 잔디가 심어집니다.<br>
  그리고 그 잔디는 여러분의 Github에 표시되죠<br>
  그 잔디 이쁘게 꾸며보고 싶다는 생각해보시진 않으셨나요?<br>
  그런 여러분을 위해 만든 프로그램입니다.
### 뭘 해주나요?
1. 특정 날짜에 잔디를 심을 수 있습니다.
2. 특정 기간동안 잔디를 심을 수 있습니다.
3. (구현예정)특정 기간에 원하는 텍스트를 입력할 수 있습니다.

위의 기능을 이용해서 깃허브 잔디밭에 잔디로 그림이나 텍스트를 남길 수 있습니다!<br>
(사실 일주일이 7일이라 칸이 적어 그림은 좀 쉽지 않을 것 같기는 합니다.)

### 사용법
1. 깃허브에 레포지토리를 생성합니다.
   -  <details>
        <summary><b>대상 레포지토리가 Private인 경우</b></summary>
        <div markdown="1">
          <ul>
            <li>자신의 깃허브 프로필 접속</li>
            <li>하단 잔디의 Contribution setting 클릭</li>
            <img src="https://github.com/user-attachments/assets/38da6537-db44-4b9a-b42d-b08f1f5f3c8f">
            <li>Private contributions 체크</li>
            <img src="https://github.com/user-attachments/assets/9e0f1392-9a3f-43f7-8f6e-ec80d4deeeec">
          <div><b>해당 체크가 되어있지 않으면 다른 유저는 Private 레포지토리의 잔디가 보이지 않습니다.<br>
                  해당 체크를 하더라도 레포지토리의 내용은 보이지 않으니 보안은 안심하셔도 됩니다.</b></div>
                  <img src="https://github.com/user-attachments/assets/4425f3b1-4a6b-4062-b1dd-2851ca2801e6">
          </ul>
        </div>
      </details>
   - 이미 생성된 레포지토리를 사용해도 무관하나, 만약을 위해 새로 생성하는 것을 권장합니다.
   - 특히 팀프로젝트면 팀원들에게 인기만점이 될 수 있으니 개인 프로젝트를 권고합니다.
2. 해당 레포지토리를 clone 합니다.<br>
   ![image](https://github.com/user-attachments/assets/f4c02b45-8d06-4a57-a681-30300053be80)
3. 이 프로젝트의 GithubGrassTextMakerApplication을 실행합니다.
4. 아까 clone한 레포지토리를 붙여넣습니다.
   ![image](https://github.com/user-attachments/assets/0cfcb956-b147-40f3-9c9e-e7a269e840be)
5. 원하는 메뉴를 선택합니다.<br>
   ![image](https://github.com/user-attachments/assets/4dbd306c-2fb5-437f-94e9-4ca7a3730dec)
6. <details markdown="1">
     <summary>특정 날짜 commit</summary>
     <div>
       <ul>
         <li>날짜 입력</li>
         <img src="https://github.com/user-attachments/assets/09bcde8f-c665-4209-8d62-d88e29bf6542">
       </ul>
     </div>
   </details>
7. <details markdown="1">
     <summary>특정 기간 commit</summary>
     <div>
       <ul>
         <li>시작 날짜, 종료 날짜 입력</li>
         <img src="https://github.com/user-attachments/assets/f0c904b1-835b-4499-a13d-7725594b7110">
       </ul>
     </div>
   </details>
8. 결과 확인
   - 명확히 하기 위해 깃허브를 로그아웃하거나 크롬의 시크릿 모드로 확인하시는 걸 권장 드립니다.
