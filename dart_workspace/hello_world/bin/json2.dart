import 'dart:convert';

var scores=[
  {'score':40},
  {'score':80},
  {'score':100, 'overtime':true, 'special':null},
];

void main(){
  var jsonText = jsonEncode(scores);
  print(jsonText == '[{"score":40},{"score":80},'
                    '{"score":100,"overtime":true,'
                    '"special":null}]');

                    print(scores is List); //[] 는 list
                    print(scores[0] is Map); // {}는 map
}
