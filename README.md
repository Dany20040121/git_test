# 계산기 프로젝트

Java Swing을 사용하여 구현한 GUI 계산기 애플리케이션입니다. 이 애플리케이션은 기본적인 사칙연산(더하기, 빼기, 곱하기, 나누기)을 수행하며, 백스페이스, 화면 지우기, 퍼센트 계산 등의 기능을 지원합니다.

## 기능 소개

- **사칙연산**: 더하기, 빼기, 곱하기, 나누기 연산을 지원합니다.
- **백스페이스**: `←` 버튼을 누르면 마지막 입력한 숫자나 연산 기호가 삭제됩니다.
- **퍼센트 계산**: `%` 버튼을 눌러 백분율을 계산할 수 있습니다.
- **부호 변경**: `+/-` 버튼을 눌러 양수와 음수를 전환할 수 있습니다.
- **C 버튼**: `C` 버튼을 눌러 현재 입력된 계산을 초기화합니다.

## 사용 기술

- **Javax Swing**: GUI 구성 및 이벤트 처리를 위해 사용되었습니다.
- **AWT**: JFrame나 ActionListener등을 수행하기 위해 사용되었습니다.

## 클래스 및 메서드 설명

- `calculator01`: 계산기의 메인 클래스입니다. JFrame을 상속하며, UI 초기화 및 메인 메서드를 포함합니다.
  - `showNorth()`: 상단에 계산 결과를 표시하는 JTextField를 설정합니다.
  - `showCenter()`: 중앙에 숫자 및 연산 버튼을 추가합니다.
  - `ButtonListener`: 버튼 클릭 시 이벤트를 처리하는 내부 클래스입니다.
  - `calculate()`: 입력된 계산식에 따라 연산을 수행하고 결과를 반환합니다.
  - `fullTextParseing()`: 계산식 문자열을 숫자와 연산 기호로 분리하여 리스트에 저장합니다.
  
## UI 설명

- **JTextField (cal_text)**: 계산기의 상단에 위치하여 결과를 표시합니다. 텍스트 필드 배경색과 글꼴 크기를 조정하여 가독성을 높였습니다.
- **버튼 배열 (button_names)**: C, %, 숫자, 연산 기호 등 다양한 기능을 수행하는 버튼들로 구성되어 있습니다.
  - 기본적으로 `0xF9F9F9` 배경색을 가지며, 연산 기호 및 특별한 기능 버튼에는 추가 색상을 적용하여 구분했습니다.

## 실행 화면
- **초기 화면**

![스크린샷 2024-11-01 212031](https://github.com/user-attachments/assets/9a26f18c-3505-4fc8-a92c-758b04bc4c3d)
- **단순 연산 이전**

 ![스크린샷 2024-11-01 212529](https://github.com/user-attachments/assets/cc56c043-ac6f-480b-bac4-7d617c492c32)

- **단순 연산 이후**

![스크린샷 2024-11-01 212539](https://github.com/user-attachments/assets/c269c8b1-2576-4d2f-9b67-89bd355298be)


- **우선 순위 연산자**

![스크린샷 2024-11-01 212559](https://github.com/user-attachments/assets/738fb152-2be7-462e-ac05-5fa45ce3a864)
![스크린샷 2024-11-01 212610](https://github.com/user-attachments/assets/163d7dbb-2c49-4d24-add1-1da897d950af)

- **음수 연산**

![스크린샷 2024-11-01 213848](https://github.com/user-attachments/assets/107180d0-7fd2-491e-9566-c0d2ae8c1c45)
![스크린샷 2024-11-01 212636](https://github.com/user-attachments/assets/30619366-d6fe-4e10-ab47-d8e5c1925c9e)
