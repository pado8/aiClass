printInteger(int aNumber) {
  print('The number is $aNumber.');
}

Future checkVersion() async{
  var version = lookUpVersion();
  print('The version is $version.');
}

int lookUpVersion() {
  return 12;
}

Future<String> getVersionName() async {
  var versionName = lookupVersionName();
  return versionName;
}

String lookupVersionName(){
  return "Android Q";
}

void printOne() {
  print("One");
}

void printThree(){
  print("Three");
}

void printTwo() async { 
  Future.delayed(Duration(seconds: 1), () {
    print("Future!!");
  });
  print("Two");
}

void main(List<String> arguments) {
  // var number = 42;
  // printInteger(number);
  // print('Hello world: ${hello_world.calculate()}!');
  // checkVersion();
  // print('end process');

  // getVersionName().then((value) => print(value));
  // print('end process');


  printOne();
  printTwo();
  printThree();


}
