using NMF.Models;
using NMF.Synchronizations;
using NMF.Transformations;

// Setup
namespace HSRM.TTC2023.ClassToRelational
{
    // Setup
    internal class NMFSolution : SolutionBase
    {
        ClassToRelational synchronization = new ClassToRelational();

        protected override void Initialize()
        {
            synchronization.Initialize();
        }

        protected override Model Transform(Model inputModel)
        {
            Model? target = null;
            synchronization.Synchronize(ref inputModel, ref target, SynchronizationDirection.LeftToRight, ChangePropagationMode.OneWay);
            return target!;
        }
    }
}
