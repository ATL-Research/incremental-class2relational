using NMF.Models;
using NMF.Synchronizations;
using NMF.Transformations;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HSRM.TTC2023.ClassToRelational
{
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
