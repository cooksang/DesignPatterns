package vaskaran.chainofresponsibility;

public class ChainOfResponsibility {
	enum MessagePriority{
		nurmal,
		hight
	}
	
	static class Message{
		public String text;
		public MessagePriority priority;
		
		public Message(String msg, MessagePriority p){
			text = msg;
			this.priority = p;
		}
		
		interface IReceiver{
			Boolean processMessage(Message msg);
		}
		
		class IssueRaiser{
			public IReceiver setFirstReceiver;
			public IssueRaiser(IReceiver firstReceiver){
				this.setFirstReceiver = firstReceiver;
			}
			public void RaiseMessage(Message msg){
				if(setFirstReceiver != null){
					setFirstReceiver.processMessage(msg);
				}
			}
		}
		class FaxErrorHandler implements IReceiver{
			
			private IReceiver nextReceiver;
			public FaxErrorHandler(IReceiver nextReceiver){
				this.nextReceiver = nextReceiver;
			}
			@Override
			public Boolean processMessage(Message msg) {
				if(msg.text.contains("Fax")){
					System.out.println("fax error handler processed " + msg.priority + msg.text);
					return true;
				} else{
					if(this.nextReceiver != null){
						this.nextReceiver.processMessage(msg);
					}
				}
				return false;
			}
			
		}
	}
	
}
