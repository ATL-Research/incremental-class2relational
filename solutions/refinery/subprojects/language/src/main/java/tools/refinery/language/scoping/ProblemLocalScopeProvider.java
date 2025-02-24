/*
 * SPDX-FileCopyrightText: 2021-2023 The Refinery Authors <https://refinery.tools/>
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package tools.refinery.language.scoping;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceDescriptionsProvider;
import org.eclipse.xtext.resource.ISelectable;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;

import com.google.inject.Inject;

import tools.refinery.language.utils.ProblemUtil;

public class ProblemLocalScopeProvider extends ImportedNamespaceAwareLocalScopeProvider {
	private static final QualifiedName BUILTIN_LIBRARY_QUALIFIED_NAME = QualifiedName
			.create(ProblemUtil.BUILTIN_LIBRARY_NAME);

	@Inject
	private IResourceDescriptionsProvider resourceDescriptionsProvider;

	@Override
	protected List<ImportNormalizer> getImplicitImports(boolean ignoreCase) {
		return List.of(doCreateImportNormalizer(BUILTIN_LIBRARY_QUALIFIED_NAME, true, ignoreCase));
	}

	@Override
	protected List<ImportNormalizer> getImportedNamespaceResolvers(EObject context, boolean ignoreCase) {
		return List.of();
	}

	@Override
	protected ISelectable internalGetAllDescriptions(Resource resource) {
		// Force the use of ProblemResourceDescriptionStrategy to include all QualifiedNames of objects.
		IResourceDescriptions resourceDescriptions = resourceDescriptionsProvider
				.getResourceDescriptions(resource.getResourceSet());
		return resourceDescriptions.getResourceDescription(resource.getURI());
	}
}
