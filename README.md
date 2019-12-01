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
    
- [x] Vector
    - 두 점을 받아 두 번째 점에서 첫 번째 점을 빼서 벡터를 만든다.
    - 다른 벡터를 인자로 받아 내적을 계산한다.
    
- [x] FigureType
    - FigureType enum
    
- [x] Figure
    - Figure 인터페이스는 getType(), getPoints(), calculate() 메서드를 갖는다.
    
- [x] Line
    - 두 점 사이의 거리를 계산한다.
    - [제약조건] 두 개의 서로다른 점을 인자로 받아야한다.

- [x] Triangle
    - [x] 점 3개를 생성자의 인자로 받는다.
    - [x] [제약조건] 점 사이에 중복이 존재하면 안 된다.
    - [x] [제약조건] 점들이 한 직선 위에 존재하면 안 된다.
    - [x] 삼각형의 넓이를 계산한다.
    
- [x] Rectangle
    - [x] 점 4개를 생성자의 인자로 받는다.
    - [x] [제약조건] 점 사이에 중복이 존재하면 안 된다.
    - [x] 인자로 받은 4 개의 점을 정렬하여 순서대로 만든다.
    - [x] [제약조건] 직사각형임을 보장한다. 직사각형의 정의는 "네 각이 모두 직각인 사각형" 이다.

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
- p1.getX() - p2.getX() => p1.subX(p2) 투머치?
- 인자로 들어온 동일한 타입의 객체의 private 필드에 접근하는 것은 안티패턴?
- Figure 가 계산하는 값이 길이인지(선인 경우), 면적인지(삼각형, 사각형인 경우) 어떻게 확인해야 좋을까?
- Point 는 인자로 XCoordinate, YCoordinate 을 받고, Line 은 인자로 List<Point> 를 받는다. 그러다보니 Line을 생성하는 로직이 너무 귀찮아졌다.
이런 문제는 어떻게 해결하야할까?