using NMF.Models;

namespace HSRM.TTC2023.ClassToRelational
{
    // Setup
    internal class CSharpSolution : SolutionBase
    {
        protected override Model Transform(Model inputModel)
        {
            var transformer = new CSharpClassToRelational();
            return transformer.Transform(inputModel);
        }
    }
}
