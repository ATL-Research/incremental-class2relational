
using NMF.Models;

// Setup
namespace HSRM.TTC2023.ClassToRelational
{
    internal class CSharpSolution : SolutionBase
    {
        protected override Model Transform(Model inputModel)
        {
            var transformer = new CSharpClassToRelational();
            return transformer.Transform(inputModel);
        }
    }
}
