package controller;

import java.util.concurrent.Semaphore;

public class ThreadSemaforo extends Thread {
	
	private Semaphore semaforo; 
	private int Id;
	
	public ThreadSemaforo(Semaphore semaforo, int Id){
		this.semaforo = semaforo;
		this.Id = Id;
	}
	
	@Override
	public void run() {
		try {
			semaforo.acquire();
			Cruzar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			semaforo.release();
		}
	}
	
	private void Cruzar(){
		switch(Id){
		case 1: System.out.println("Carro "+Id+" passando da esquerda para a direita");
		break;
		case 2: System.out.println("Carro "+Id+" passando da direita para a esquerda");
		break;
		case 3: System.out.println("Carro "+Id+" passando de cima para baixo");
		break;
		case 4: System.out.println("Carro "+Id+" passando de baixo para cima");
		break;
		}
		try {
			sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
