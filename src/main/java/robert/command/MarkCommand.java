package robert.command;

import robert.exception.RobertException;
import robert.storage.Storage;
import robert.task.TaskList;
import robert.ui.Ui;

/**
 * A Mark extension of the <tt>Command</tt> class. Used to mark
 * a particular task in the list of tasks.
 *
 * @author Lee Zhan Peng
 */
public class MarkCommand extends Command {

    /** The index of task to be marked */
    private final int markIndex;

    /**
     * Constructs MarkCommand using an index.
     *
     * @param markIndex the index of task to be marked.
     */
    public MarkCommand(int markIndex) {
        this.markIndex = markIndex;
    }

    /**
     * Executes the marking of the particular task.
     *
     * @param tasks the list of tasks to be added onto.
     * @param ui the ui that is responsible for the output of the CLI.
     * @param storage the storage that loads stored tasks from hard disk.
     * @throws RobertException if index is out of bounds of the list of tasks.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws RobertException {
        tasks.markTask(this.markIndex);
        ui.showMessage("Nice! I've marked this task as done:\n  "
                + tasks.getTask(this.markIndex));
    }
}
