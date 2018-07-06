
public class Student2 extends Person{

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName(name);
	}

	@Override
	public int getAge() {
		// TODO Auto-generated method stub
		return super.getAge();
	}

	@Override
	public void setAge(int age) {
		// TODO Auto-generated method stub
		super.setAge(age);
	}


	@Override
	public void setPerson(Person person) {
		super.name = person.getName();
		super.age = person.getAge();
	}

	@Override
	public String toString() {
		return "getName()=" + getName() + ", getAge()=" + getAge() + "]";
	}

}
