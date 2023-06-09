using HSRM.TTC2023.ClassToRelational.Class_;
using HSRM.TTC2023.ClassToRelational.Relational_;
using NMF.Models;
using NMF.Models.Changes;
using NMF.Models.Repository;
using NMF.Models.Repository.Serialization;
using NMF.Serialization;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Attribute = HSRM.TTC2023.ClassToRelational.Class_.Attribute;
using Type = HSRM.TTC2023.ClassToRelational.Relational_.Type;

namespace HSRM.TTC2023.ClassToRelational
{
    public abstract class SolutionBase
    {
        private readonly ModelRepository _modelRepository = new ModelRepository(MetaRepository.Instance, null, new FixedFileLocator());

        public void Run()  
        {
            try
            {
                var sourcePath = GetOrThrow("SOURCE_PATH");
                var changePath = GetOrThrow("CHANGE_PATH");

                _modelRepository.UnresolvedModelElement += HelpResolve;

                var classSerializer = new ModelSerializer(XmlSerializationSettings.Default, new[]
                {
                    typeof(Class), typeof(Attribute), typeof(DataType), typeof(Model)
                });

                Model sourceModel;
                using (var file = File.OpenRead(sourcePath))
                {
                    sourceModel = classSerializer.Deserialize(file, new Uri(Path.GetFullPath(sourcePath)), _modelRepository, true);
                }
                var changeModel = _modelRepository.Resolve(changePath);

                var changeSet = changeModel.RootElements.FirstOrDefault() as ModelChangeSet ?? new ModelChangeSet();

                if (changeSet == null)
                {
                    throw new Exception("Change set was not loaded correctly");
                }

                Model targetModel;

                if (IsBatchMode)
                {
                    ApplyChanges(changeSet);
                    targetModel = Transform(sourceModel);
                }
                else
                {
                    targetModel = Transform(sourceModel);
                    ApplyChanges(changeSet);
                }

                SaveTarget(targetModel);
            }
            catch (Exception ex)
            {
                Console.Error.WriteLine(ex.ToString());
            }
        }

        private void HelpResolve(object? sender, UnresolvedModelElementEventArgs e)
        {
            var newUri = new Uri("https://github.com/ATL-Research/incremental-class2relational/Class.nmeta" + e.Uri.Fragment);
            e.ModelElement = _modelRepository.Resolve(newUri);
        }

        protected virtual void Initialize() { }

        protected abstract Model Transform(Model inputModel);

        private void SaveTarget(Model target)
        {
            var targetPath = GetOrThrow("TARGET_PATH");
            _modelRepository.Save(target, targetPath);
        }

        private void ApplyChanges(ModelChangeSet changeSet)
        {
            changeSet.Apply();
        }

        public bool IsBatchMode => Environment.GetEnvironmentVariable("BATCH_MODE") != null;

        private string GetOrThrow(string variable)
        {
            return Environment.GetEnvironmentVariable(variable) ?? throw new Exception($"Variable {variable} is not defined");
        }
    }
}
