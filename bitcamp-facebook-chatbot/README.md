#페이스북 메신저 챗봇 만들기

## 예제 프로젝트 다운로드
-페이스북 예제 파일을 깃허브에서 가져온다.
 - https://github.com/fbsamples/messenger-platform-samples.git
- 예제 프로젝트를 개인 깃허브 저장소로 복사하고 이름을 바꾼다.
 -예) java106-facebookp-chatbot
- gradle로 이클립스 설정 파일을 만든 후 이클립스로 임포트 한다.

## 페이스북 페이지를 생성한다.
- 가상의 대화 상대 역할을 할 페이지를 생성한다.
페이스북 메인 - 프로필 사진 클릭 - 페이지 만들기 - 커뮤니티 또는 공인 선택 - 페이지 이름(OOO의 챗봇) - 카테고리 선택(개발 블로그) - 프로필 사진 건너뛰기

## 페이스북 앱에 메신저 API를 추가한다.
- 페이스북 앱이 없으면, 새로 만들라.

facebook for developers - Messenger 설정 - OOO의 챗봇 선택 - 페이스북 페이지 토큰 복사 - app.js에서 process.emv.VERIFY_TOKEN - putty를 이용해 리눅스 접속 - nano .bash_profile - 



# Quick Start Tutorial - Finished Project

This is the final code for the [Messenger Platform quick start tutorial](https://developers.facebook.com/docs/messenger-platform/getting-started/quick-start). 

If you want to follow the quick start from scratch, download the starter code from the [tutorial-starters branch](https://github.com/fbsamples/messenger-platform-samples/tree/tutorial-starters/quick-start) of this repo.

### More Resources

To learn more about the Messenger Platform, check out these other resources:

- **[📚 Docs Docs Docs](https://developers.facebook.com/docs/messenger-platform/)**: Learn about all the features available for building awesome Messenger bots.
- **[📱 Advanced Sample Apps](https://github.com/fbsamples/messenger-bot-samples)**: Download our samples that show off some of the Platform's most popular features.
- **[😺 Developer Community](https://www.facebook.com/groups/messengerplatform/)**: Join our developer community! Get help. Give help. Ship ❤️
