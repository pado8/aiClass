import 'dart:convert';

void main() {
  var jsonString = '''
[
  {"score": 40"},
  {"score": 80"}

]
  ''';

  var scores = jsonDecode(jsonString); //json으로 인코딩
  print(scores is List);
  var firstScore = scores[0];
  print(firstScore is Map);
  print(firstScore['score'] == 40);

}