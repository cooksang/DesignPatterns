package vaskaran.command;

import vaskaran.command.CommandPattern.Invoker;
import vaskaran.command.CommandPattern.MyRedoCommand;
import vaskaran.command.CommandPattern.MyUndoCommand;
import vaskaran.command.CommandPattern.Receiver;

public class CommandPatternExcute {
	public static void main(String[] args) {
		System.out.println("** Command Pattern Demo **\n");
		Receiver intendedReceiver = new Receiver();
		Invoker invoke = new Invoker();
		
		MyUndoCommand undoCommand = new MyUndoCommand(intendedReceiver);
		MyRedoCommand redoCommand = new MyRedoCommand(intendedReceiver);
		
		invoke.ExcuteCommand(undoCommand);
		invoke.ExcuteCommand(redoCommand);
		
	}
}
