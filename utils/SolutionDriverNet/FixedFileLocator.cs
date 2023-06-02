using NMF.Models.Repository;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HSRM.TTC2023.ClassToRelational
{
    public class FixedFileLocator : IModelLocator
    {
        public bool CanLocate(Uri uri)
        {
            return uri != null && ((uri.IsAbsoluteUri && uri.IsFile && File.Exists(uri.AbsolutePath)) || (!uri.IsAbsoluteUri && File.Exists(uri.OriginalString)));
        }

        public Uri GetRepositoryUri(Uri uri)
        {
            if (uri == null) throw new ArgumentNullException("uri");
            if (uri.IsAbsoluteUri)
            {
                return new Uri(uri.GetLeftPart(UriPartial.Query), UriKind.Absolute);
            }
            else
            {
                return new Uri(Path.GetFullPath(uri.OriginalString));
            }
        }

        public Stream Open(Uri repositoryId)
        {
            if (repositoryId == null) throw new ArgumentNullException("uri");
            if (repositoryId.IsAbsoluteUri)
            {
                return new FileStream(repositoryId.LocalPath, FileMode.Open, FileAccess.Read);
            }
            else
            {
                return new FileStream(repositoryId.OriginalString, FileMode.Open, FileAccess.Read);
            }
        }
    }
}
