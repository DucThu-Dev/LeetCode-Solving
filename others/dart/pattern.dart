void main(List<String> args) {
  /// TEST 1
  const a = 'a', b = 'b';
  var input = ['a', 'b'];

  switch (input) {
    case [a, b]:
      print('My pattern: $input');
      break;
    default:
      print('input else $input');
  }

  /// TEST 2
  final myList = [1, 2, 3];
  final [a0, b0, c0] = myList;
  print('TEST 2: ${a0 + b0 + c0}');

  /// TEST 3
  (int, String) output = (12, 'This is my message.');
  var (number, message) = output;

  /// TEST 4
  String? validateMsg = 'Oh my Dart, you have pattern!';
  validateMsg = null;
  switch (validateMsg) {
    case var s?:
      print('Error occurred: $s');
      break;
    case null:
      print('Validate pass! No error occurred');
    default:
  }

  /// TEST 5
  switch (('Some of my Work', 34)) {
    case (var aa, var bb, var cc):
      print('Pattern aa bb cc match: $aa, $bb, $cc');
      break;
    case (String aa, int bb):
      print('Pattern String aa int bb match: $aa, $bb');
      break;
    default:
      print('None of above pattern match');
  }

  /// TEST 6
  var test6List = [1, 2, 3];
  var [_, i2, _] = test6List;
  print('Middle value is $i2');

  /// TEST 7
  final myPoint = ChildPoint(10, 20);
  final MyPoint(:y, :x) = myPoint;
  print('My point is $x, $y');

  /// TEST 8
  final pair = (22, 18);
  switch (pair) {
    case (var a, var b) when a < b:
      print('Sum of a and b: ${a + b}');
      break;
    case (var a, var b) when a > b:
      print('Sub of a and b: ${a - b}');
      break;
    default:
      print('No join');
  }
}

class MyPoint {
  MyPoint(this.x, this.y);

  final x;
  final y;
}

class ChildPoint extends MyPoint {
  ChildPoint(super.x, super.y);
}
