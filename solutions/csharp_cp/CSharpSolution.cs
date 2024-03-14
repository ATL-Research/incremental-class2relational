using NMF.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

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
