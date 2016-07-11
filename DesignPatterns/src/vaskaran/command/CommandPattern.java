package vaskaran.command;

public class CommandPattern {
	interface ICommand{
		void excute();
	}
	
	static class MyUndoCommand implements ICommand{
		private Receiver receiver;
		MyUndoCommand(Receiver receiver) {
			this.receiver = receiver;
		}
		@Override
		public void excute() {
			receiver.performUndo();
			
		}
	}
	
	static class MyRedoCommand implements ICommand{
		private Receiver receiver;
		
		MyRedoCommand(Receiver receiver) {
			this.receiver = receiver;
		}
		
		@Override
		public void excute() {
			receiver.performRedo();
			
		}
	}
	
	static class Receiver{
		private void performUndo(){
			System.out.println("excuting - myundo command");
		}
		
		private void performRedo(){
			System.out.println("excuting - myredo command");
		}
	}
	
	static class Invoker{
		ICommand command;
		
		public void ExcuteCommand(ICommand command){
			this.command = command;
			this.command.excute();
		}
	}
	
}
