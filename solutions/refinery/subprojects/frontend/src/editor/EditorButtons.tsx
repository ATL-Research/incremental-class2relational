/*
 * SPDX-FileCopyrightText: 2021-2023 The Refinery Authors <https://refinery.tools/>
 *
 * SPDX-License-Identifier: EPL-2.0
 */

import type { Diagnostic } from '@codemirror/lint';
import CancelIcon from '@mui/icons-material/Cancel';
import CheckIcon from '@mui/icons-material/Check';
import FormatListNumberedIcon from '@mui/icons-material/FormatListNumbered';
import FormatPaint from '@mui/icons-material/FormatPaint';
import InfoOutlinedIcon from '@mui/icons-material/InfoOutlined';
import RedoIcon from '@mui/icons-material/Redo';
import SearchIcon from '@mui/icons-material/Search';
import UndoIcon from '@mui/icons-material/Undo';
import WarningIcon from '@mui/icons-material/Warning';
import IconButton from '@mui/material/IconButton';
import Stack from '@mui/material/Stack';
import ToggleButton from '@mui/material/ToggleButton';
import ToggleButtonGroup from '@mui/material/ToggleButtonGroup';
import { observer } from 'mobx-react-lite';

import ConnectButton from './ConnectButton';
import type EditorStore from './EditorStore';

// Exhastive switch as proven by TypeScript.
// eslint-disable-next-line consistent-return
function getLintIcon(severity: Diagnostic['severity'] | undefined) {
  switch (severity) {
    case 'error':
      return <CancelIcon fontSize="small" />;
    case 'warning':
      return <WarningIcon fontSize="small" />;
    case 'info':
      return <InfoOutlinedIcon fontSize="small" />;
    default:
      return <CheckIcon fontSize="small" />;
  }
}

export default observer(function EditorButtons({
  editorStore,
}: {
  editorStore: EditorStore | undefined;
}): JSX.Element {
  return (
    <Stack direction="row" flexGrow={1}>
      <IconButton
        disabled={editorStore === undefined || !editorStore.canUndo}
        onClick={() => editorStore?.undo()}
        aria-label="Undo"
        color="inherit"
      >
        <UndoIcon fontSize="small" />
      </IconButton>
      <IconButton
        disabled={editorStore === undefined || !editorStore.canRedo}
        onClick={() => editorStore?.redo()}
        aria-label="Redo"
        color="inherit"
      >
        <RedoIcon fontSize="small" />
      </IconButton>
      <ToggleButtonGroup size="small" className="rounded" sx={{ mx: 1 }}>
        <ToggleButton
          selected={editorStore?.showLineNumbers ?? false}
          disabled={editorStore === undefined}
          onClick={() => editorStore?.toggleLineNumbers()}
          aria-label="Show line numbers"
          value="show-line-numbers"
        >
          <FormatListNumberedIcon fontSize="small" />
        </ToggleButton>
        <ToggleButton
          selected={editorStore?.searchPanel?.state ?? false}
          disabled={editorStore === undefined}
          onClick={() => editorStore?.searchPanel?.toggle()}
          aria-label="Show find/replace"
          {...(editorStore !== undefined &&
            editorStore.searchPanel.state && {
              'aria-controls': editorStore.searchPanel.id,
            })}
          value="show-search-panel"
        >
          <SearchIcon fontSize="small" />
        </ToggleButton>
        <ToggleButton
          selected={editorStore?.lintPanel?.state ?? false}
          disabled={editorStore === undefined}
          onClick={() => editorStore?.lintPanel.toggle()}
          aria-label="Show diagnostics panel"
          {...(editorStore !== undefined &&
            editorStore.lintPanel.state && {
              'aria-controls': editorStore.lintPanel.id,
            })}
          value="show-lint-panel"
        >
          {getLintIcon(editorStore?.delayedErrors?.highestDiagnosticLevel)}
        </ToggleButton>
      </ToggleButtonGroup>
      <IconButton
        disabled={editorStore === undefined || !editorStore.opened}
        onClick={() => editorStore?.formatText()}
        aria-label="Automatic format"
        color="inherit"
      >
        <FormatPaint fontSize="small" />
      </IconButton>
      <ConnectButton editorStore={editorStore} />
    </Stack>
  );
});
