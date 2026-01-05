BEGIN {
   FS = ","
}

{
    first_reading = $3 $4
    second_reading = $5 $6
    avg = (first_reading + second_reading) / 2
    print "#" $1 ", " $2 " = " avg
}
