package main.converters;

import main.enums.Command;

public class ParameterConverter {

    public ParameterConverter(){}

    /**
     * Checks if we are performing the Bucket Fill function. If so, we transform the draw character into ASCII for later validation.
     * @param command Current command.
     * @param input User input.
     * @return Returns just the parameters without the command.
     */
    public int[] convertParameters(String command, String[] input){
        int[] parameters = new int[input.length - 1];

        if(command.equals(Command.B.toString())){
            for(int i = 0; i < parameters.length; i++){
                if(i == 2){
                    //ASCII
                    char draw = input[i+1].charAt(0);
                    parameters[i] = draw;
                } else {
                    parameters[i] = Integer.parseInt(input[i+1]);
                }
            }
        } else {
            for(int i = 0; i < parameters.length; i++){
                parameters[i] = Integer.parseInt(input[i+1]);
            }
        }
        return parameters;
    }
}
