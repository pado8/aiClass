class Car {
  int? maxSpeed;
  num? price;
  String? name;

  Car(int this.maxSpeed , num this.price , String this.name);
  
  num? saleCar(){
    price = price! * 0.9 ;
    return price;
  }
}

void main() {
  Car bmw = Car(320, 100000, 'BMW'); //instance 생성
  Car toyota = Car(250, 70000, 'TOYOTA'); //instance 생성
  Car ford = Car(200, 80000, 'FORD'); //instance 생성
  bmw.saleCar();
  toyota.saleCar();
  ford.saleCar();
  print(bmw.price);
}