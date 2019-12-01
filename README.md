# java-coordinate
좌표계산기 미션을 진행하기 위한 저장소

요구사항: https://techcourse.woowahan.com/s/1aKh56So/ls/hugu4eYX

# To-do-list
- [x] XCoordinate, YCoordinate
    - X, Y 좌표는 0~24 사이의 정수값으로 가정한다.
    - 캐싱을 통해 객체의 재생성을 막는다.
    
- [x] Point
    - X, Y 좌표 각각을 받아 점을 만든다.
    - X 좌표에 대한 Getter, Y 좌표에 대한 Getter 가 존재한다.
    
- [ ] Vector
    - 두 점을 받아 두 번째 점에서 첫 번째 점을 빼서 벡터를 만든다.
    - 다른 벡터를 인자로 받아 내적을 계산한다.
    
- [ ] Line
    - [ ] 점 2개를 생성자의 인자로 받는다.
    - [ ] 두 점 사이의 거리를 계산한다.

- [ ] Triangle
    - [ ] 점 3개를 생성자의 인자로 받는다.
    - [ ] [제약조건] 점 사이에 중복이 존재하면 안 된다.
    - [ ] 삼각형의 넓이를 계산한다.
    
- [ ] Rectangle
    - [ ] 점 4개를 생성자의 인자로 받는다.
    - [ ] [제약조건] 점 사이에 중복이 존재하면 안 된다.
    - [ ] 인자로 받은 4 개의 점을 정렬하여 순서대로 만든다.
    - [ ] [제약조건] 직사각형임을 보장한다. 직사각형의 정의는 "네 각이 모두 직각인 사각형" 이다.

- [ ] ConsoleInputView
    - [ ] 사용자로부터 좌표들을 입력받는다. (e.g., "(1,1)-(2,2)")

- [ ] ConsoleOutputView
    - [ ] 선, 삼각형, 사각형인지에 따라 길이 혹은 넓이를 출력한다.
    - [ ] 좌표평면을 그리고 좌표를 특수문자로 표현한다. (Optional)
    
# Refactoring / Thoughts
- XCoordinate, YCoordinate 을 enum 으로 만든다면?
- XCoordinate 과 YCoordinate 코드의 상당부분이 중복. 허용 가능한 중복인가?
- Point 객체가 XCoordinate 을 가지고 있고, XCoordinate 은 integer value 를 가지고 있다. 이상황에서
Point 객체에 getX() 메서드가 있을 때, XCoordinate 객체를 리턴하는 게 맞을까 아니면 getter 를 호출해서 integer value 를 꺼내서
리턴하는 게 맞을까? 후자의 경우 Point 안에 XCoordinate 객체가 존재한다는 것을 밝히지 않을 수 있다는 장점이 있을 것이고,
전자의 경우 원시값보다 객체를 리턴함으로써 더 안전하게 정보를 전달할 수 있을 것이다.