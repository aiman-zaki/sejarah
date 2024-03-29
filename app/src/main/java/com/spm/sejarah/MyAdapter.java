package com.spm.sejarah;

/*

public class MyAdapter extends  RecyclerView.Adapter<MyAdapter.ViewHolder> {

    RecyclerView recyclerView;
    Context context;
    ArrayList<String> items =new ArrayList<>();
    ArrayList<String> urls =new ArrayList<>();

    public void update(String name, String url)
    {
        items.add(name);
        urls.add(url);
        notifyDataSetChanged(); //refreshes the recycle view automatically.
    }


    public MyAdapter(RecyclerView recyclerView, Context context, ArrayList<String> items, ArrayList<String> urls) {
        this.recyclerView = recyclerView;
        this.context = context;
        this.items = items;
        this.urls = urls;
    }
/*
    @Override
    //to create views for recycler view item
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.items,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //initialize the elements of individual items..

        holder.nameOfFile.setText(items.get(position));


    }


    @Override
    public int getItemCount() {

        //return number of items

        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameOfFile;


        //viewholder: create individual recycler view item
        //itemview represents indiv list item
        public ViewHolder(View itemView) {
            super(itemView);
           // nameOfFile=itemView.findViewById(R.id.nameofFile);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int position=recyclerView.getChildLayoutPosition(view);
                    Intent intent = new Intent();
                    intent.setType(Intent.ACTION_VIEW); //denotes that we are going to view something
                    intent.setData(Uri.parse(urls.get(position)));
                    context.startActivity(intent);


                }
            });
        }

    }


} */
