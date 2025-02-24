using NMF.Models.Changes;
using NMF.Models.Meta;

namespace HSRM.TTC2023.ClassToRelational.Changes
{
    public partial class AddToRoot
    {
        public override void Apply()
        {
            AffectedElement.Model.RootElements.Add(NewObject);
        }

        public override IEnumerable <IModelChange> Invert()
        {
            throw new NotSupportedException();
        }
    }

    public partial class DeleteFromRoot
    {
        public override void Apply()
        {
            DeletedElement.Delete();
        }

        public override IEnumerable <IModelChange> Invert()
        {
            throw new NotSupportedException();
        }
    }

    public partial class ReferenceSetNull
    {
        public override void Apply()
        {
            AffectedElement.SetReferencedElement((IReference)Feature, null);
        }

        public override IEnumerable <IModelChange> Invert()
        {
            throw new NotSupportedException();
        }
    }
}
