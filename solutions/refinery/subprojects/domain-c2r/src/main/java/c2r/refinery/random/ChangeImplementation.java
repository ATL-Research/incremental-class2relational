package c2r.refinery.random;

import atl.research.class_.Attribute;
import atl.research.class_.Class;
import c2r.refinery.ClassDomain;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EContentAdapter;
import tools.refinery.store.tuple.Tuple;


public class ChangeImplementation extends EContentAdapter {
	private final ClassDomain classmodel;
	public ChangeImplementation(ClassDomain classmodel) {
		this.classmodel = classmodel;
	}

	@Override
	public void notifyChanged(Notification notification){
		super.notifyChanged(notification);
		System.out.println("New notification");
		System.out.println("\tEventType="+notification.getEventType());
		System.out.println("\tNotifier="+notification.getNotifier());
		System.out.println("\tFeature="+notification.getFeature());
		System.out.println("\tNew value="+notification.getNewValue());
		System.out.println("\tOld value="+notification.getOldValue());


		var feature = notification.getFeature();
		//SET,UNSET,ADD,REMOVE,ADD_MANY,REMOVE_MANY
		if(notification.getEventType()== Notification.SET
				&& feature instanceof EAttribute attribute){
			if(attribute.getName().equals("name")){
				System.out.println("Name changed using notifier.");
				var cls = classmodel.tupleOf(notification.getNotifier());
				classmodel.name.put(cls, notification.getNewStringValue());
			}
			if(attribute.getName().equals("multiValued")){
				System.out.println("MultiValued changed using notifier.");
				var cls = classmodel.tupleOf(notification.getNotifier());
				classmodel.multiValued.put(cls, (Boolean) notification.getNewValue());
			}
		}
		if(notification.getEventType()== Notification.SET
				&& feature instanceof EReference reference){
			if(reference.getName().equals("type") && notification.getNewValue()==null){
				System.out.println("Type set to null.");
				var cls = classmodel.tupleOf(notification.getNotifier());
				var old = classmodel.tupleOf(notification.getOldValue());
				var tuple = Tuple.of(cls.get(0),old.get(0));
				classmodel.type.put(tuple,false);
			}
		}
		if(notification.getEventType()== Notification.REMOVE){
			if(feature instanceof  EReference ref && ref.getName().equals("attr")){
				System.out.println("Attribute remove."); // Attribute is a container
				var old = classmodel.tupleOf(notification.getOldValue());
				classmodel.delete(old);
			}
			if(feature == null && notification.getOldValue() instanceof Class cls){
				System.out.println("Class remove.");
				var old = classmodel.tupleOf(cls);
				classmodel.delete(old);
			}
		}
		if(notification.getEventType()== Notification.ADD){
			if(notification.getNewValue() instanceof Class cls){
				System.out.println("Add class.");
				var id = classmodel.createFrom(cls);
				classmodel.name.put(id, cls.getName());
			}
			if(notification.getNewValue() instanceof Attribute attribute){
				System.out.println("Add attribute.");
				var host = classmodel.tupleOf(attribute.getOwner());
				var id = classmodel.createFrom(attribute, host);
				classmodel.name.put(id, attribute.getName());
				classmodel.multiValued.put(id, attribute.getMultiValued());
				if(attribute.getType()!=null){
					System.out.println("Type set for new attribute.");
					var typeid = classmodel.tupleOf(attribute.getType());
					classmodel.type.put(Tuple.of(id.get(0),typeid.get(0)),true);
				}
			}
			System.out.println("Something added change."); // Attribute is a container
			//TODO new value
		}
	}
}
