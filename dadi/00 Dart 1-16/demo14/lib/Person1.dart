class Person{
  String name;
  int age; 
  //默认构造函数的简写
  Person(this.name,this.age);  
  void printInfo(){   
    print("Person1:${this.name}----${this.age}");
  }
}
