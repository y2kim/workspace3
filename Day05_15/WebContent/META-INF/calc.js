function Calc() { // 생성자
    this.plus = function (num1, num2) { //객체 형태  -> 모듈화 목적
        return num1 + num2;
    };
    this.minus = function (num1, num2) {
        return num1 - num2;
    };
    this.mul = function (num1, num2) {
        return num1 * num2;
    };
    this.divide = function (num1, num2) {
        return num1 / num2;
    };
}


var calc = {
    //리터럴
    plus: function (num1, num2) {
        return num1 + num2;
    },
    minus: function (num1, num2) {
        return num1 - num2;
    },
    mply: function (num1, num2) {
        return num1 * num2;
    },
    divide: function (num1, num2) {
        return num1 / num2;
    }
}
//        var result = colc.plus(10, 20);
//        alert(result);
//function Calc(x,x) -> 값을 바꿀때 new를 생성해야 한다
//        function Calc() { // 생성자
//            this.plus = function(num1, num2) { //객체 형태  -> 모듈화 목적
//                return num1 + num2;
//            }
//            this.minus = function(num1, num2) {
//                return num1 - num2;
//            }
//            this.mul = function(num1, num2) {
//                return num1 * num2;
//            }
//            this.divide = function(num1, num2) {
//                return num1 / num2;
//            }
//        }
